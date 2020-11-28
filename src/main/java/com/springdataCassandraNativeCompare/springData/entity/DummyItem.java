package com.springdataCassandraNativeCompare.springData.entity;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


/**
 * @author Fatih Yıldızlı
 */

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table("dummy")
public class DummyItem {


    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    private long id;
    @Column("column_1")
    private String column_1;
    @Column("column_2")
    private String column_2;

}
