package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_4_1__AddType extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO types " +
                        "(inscription_id, titre, description) values " +
                        "(1, 'Informatique', 'Formations pour informatiques')");
        statement.execute(
                "INSERT INTO types " +
                        "(inscription_id, titre, description) values " +
                        "(2, 'Langues', 'Formations pour apprendre des langues')");


    }
}