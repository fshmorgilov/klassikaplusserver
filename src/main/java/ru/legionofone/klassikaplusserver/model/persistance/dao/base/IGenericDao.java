package ru.legionofone.klassikaplusserver.model.persistance.dao.base;

import org.springframework.lang.NonNull;
import ru.legionofone.klassikaplusserver.model.persistance.entities.DbEntity;

import java.util.List;

public interface IGenericDao<T extends DbEntity> {
 
   T findOne(final long id);
 
   List<T> findAll();
 
   void create(final T entity);
 
   void update(final T entity);
 
   void delete(final T entity);
 
   void deleteById(final long entityId);


   void setClazz(@NonNull Class<T> clazzToSet) ;

   void setTableName(String tableName) ;

   void deleteAll();
}