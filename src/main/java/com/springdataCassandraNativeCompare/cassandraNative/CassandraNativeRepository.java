package com.springdataCassandraNativeCompare.cassandraNative;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;
import com.datastax.oss.driver.api.querybuilder.delete.Delete;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.datastax.oss.driver.api.querybuilder.update.Update;
import com.springdataCassandraNativeCompare.cassandraNative.config.CassandraConfig;
import com.springdataCassandraNativeCompare.springData.entity.DummyItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.*;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.bindMarker;

/**
 * @author Fatih Yıldızlı
 */
@Repository
public class CassandraNativeRepository {

    private CqlSession cqlSession = CassandraConfig.getCqlSession();

    private static PreparedStatement selectAllStatement = null;
    private static PreparedStatement insertAllStatement = null;
    private static PreparedStatement updateAllStatement = null;
    private static PreparedStatement deleteAllStatement = null;

    public List<DummyItem> selectAll() {
        if (selectAllStatement == null) {

            selectAllStatement();
        }
        try {

            List<DummyItem> response = new ArrayList<>();
            ResultSet resultSet = cqlSession.execute(selectAllStatement.bind());

            for (Row row : resultSet) {
                DummyItem item = new DummyItem(row.getLong("id"), row.getString("column_1"), row.getString(
                        "column_2"));

                response.add(item);
            }


            return response;
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return null;


    }

    private void selectAllStatement() {
        try {
            Select selectStatement = selectFrom("local",
                    "dummy").columns("id", "column_2", "column_1").all();
            selectAllStatement = cqlSession.prepare(selectStatement.build());

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void insertAll(long id) {
        try {

            if (insertAllStatement == null) {
                insertAllStatement();
            }
            BoundStatement boundStatement =
                    insertAllStatement.bind(id, "fatih", "yıldızlı"
                    );

            cqlSession.executeAsync(boundStatement);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void insertAllStatement() {
        SimpleStatement insertStatement =
                insertInto("local",
                        "dummy")
                        .value("id", bindMarker())
                        .value("column_1", bindMarker())
                        .value("column_2", bindMarker()).build();
        insertAllStatement = cqlSession.prepare(insertStatement);
    }

    public void updateAll(long id) {
        try {

            if (updateAllStatement == null) {
                updateAllStatement();
            }
            BoundStatement boundStatement = updateAllStatement.bind("FY", "yıldızlı"
                    , id);

            cqlSession.executeAsync(boundStatement);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void updateAllStatement() {
        Update updateStatement =
                update("local",
                        "dummy")
                        .setColumn("column_2", bindMarker())
                        .setColumn("column_1", bindMarker())
                        .whereColumn("id").isEqualTo(bindMarker());
        updateAllStatement =
                cqlSession.prepare(updateStatement.build());
    }

    public void deleteAll(long id) {
        try {

            if (deleteAllStatement == null) {
                deleteAllStatement();
            }
            BoundStatement boundStatement = deleteAllStatement.bind(id);

            cqlSession.executeAsync(boundStatement);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void deleteAllStatement() {
        Delete deleteStatement = deleteFrom("local",
                "dummy").whereColumn("id").isEqualTo(bindMarker());
        deleteAllStatement =
                cqlSession.prepare(deleteStatement.build());
    }

}
