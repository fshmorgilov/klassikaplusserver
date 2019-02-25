package ru.legionofone.klassikaplusserver.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.legionofone.klassikaplusserver.KlassikaplusServerApplication;
import ru.legionofone.klassikaplusserver.web.dto.obtained.CategoryDto;
import ru.legionofone.klassikaplusserver.web.dto.obtained.DataDto;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CatalogItemReceiver {

    private static final Logger logger = LoggerFactory.getLogger(CatalogItemReceiver.class);

    @Value("${site.url.collection.api}")
    private String URL;
    @Value("${site.mock.url}")
    private String URL_MOCK ;
    @Value("${site.mock.url.header.key}")
    private String X_API_KEY;
    @Value("${site.mock.url.header.value}")
    private String X_API_KEY_VALUE;

    private final OkHttpClient client = new OkHttpClient();// FIXME: 1/14/2019 bean
    private final ObjectMapper mapper = new ObjectMapper();

    public Optional<List<CategoryDto>> provide() {
        Request request = new Request.Builder()
                .url(URL + provideCurrentDate())
                .header(X_API_KEY, X_API_KEY_VALUE)
                .build();
        logger.info("Making request: " + request.toString() + "\n and headers : \n" + request.headers().toString());

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                logger.info("Response: " + response.message() + "\nheaders " + response.headers().toString());
                final String[] responseBody = new String[1];
                Optional.ofNullable(response.body().string())
                        .ifPresentOrElse(
                                (String s) -> responseBody[0] = s,
                                () -> responseBody[0] = ""
                        ); // FIXME: 1/25/2019 хуета

                DataDto dto = mapper.reader().forType(DataDto.class).readValue(responseBody[0]);
                logger.debug(dto.toString());
                return Optional.ofNullable(dto.getData());
            } else {
                logger.error("request failed");
                logger.error(" reason: " + response.message() + "\nheaders " + response.headers().toString());
                return Optional.empty();
            }
        } catch (IOException e) {
            logger.warn("Failed to make request to site:\n" + e.getMessage());
            return Optional.empty();
        }
    }

    private String provideCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(new Date());
    }
}
