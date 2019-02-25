package ru.legionofone.klassikaplusserver.model.mappers;

import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbItem;
import ru.legionofone.klassikaplusserver.web.dto.obtained.ItemDto;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ForeignDtoToDaoMapperTest {


    @Test
    public void map() {
        ForeignDtoToDaoMapper mapper = new ForeignDtoToDaoMapper();
        ItemDto mockedDto = mock(ItemDto.class);
        DbItem itemToTest = mapper.map(mockedDto);
        assertFalse(itemToTest.getNovelty());


    }
}