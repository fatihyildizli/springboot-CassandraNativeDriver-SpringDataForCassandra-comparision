package com.springdataCassandraNativeCompare.springData;

/**
 * @author Fatih Yıldızlı
 */


import com.springdataCassandraNativeCompare.springData.entity.DummyItem;
import org.springframework.data.cassandra.core.mapping.MapId;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface SpringDataRepository extends CassandraRepository<DummyItem, MapId> {

    @Query("select * from dummy;")
    List<DummyItem> selectAll();

    @Query(value = "insert into dummy (id,column_2,column_1) VALUES (:id,:column_2,:column_1)")
    void insert(@Param("id") long id, @Param("column_2") String column_2,
                @Param("column_1") String column_1);

    @Query(value = "update dummy set column_2=:column_2,column_1=:column_1 where id=:id")
    void update(@Param("id") long id, @Param("column_2") String column_2, @Param("column_1") String column_1);

    @Query("delete from dummy where id=:id")
    void delete(@Param("id") long id);
}
