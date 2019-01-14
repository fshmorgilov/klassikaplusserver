package ru.legionofone.klassikaplusserver.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.legionofone.klassikaplusserver.web.dto.obtained.CategoryDto;
import ru.legionofone.klassikaplusserver.web.dto.obtained.DataDto;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class CatalogItemReceiver {

    private static final Logger logger = LoggerFactory.getLogger(CatalogItemReceiver.class);
    private String URL = "https://klassikaplus.ru/loadsget/?parent=3&pub=1&ping=" + provideCurrentDate();

    private final OkHttpClient client = new OkHttpClient();// FIXME: 1/14/2019 bean
    private final ObjectMapper mapper = new ObjectMapper();

    @Nullable
    public List<CategoryDto> provide() {
        Request request = new Request.Builder()
                .url(URL)
                .build();
        try {
            Response response = client.newCall(request)
                    .execute();
            if (response.isSuccessful())
                if (response.body() != null)
                    return mapper.readValue(response.body().string(), DataDto.class).getData();
                else {
                    logger.warn("response body is null");
                    return null;
                }
            else {
                logger.warn("request failed");
                return null;
            }

        } catch (IOException e) {
            logger.warn("Failed to make request to site:\n" + e.getMessage());
            return null;
        }
    }

    private String provideCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        return sdf.format(new Date());
    }
}