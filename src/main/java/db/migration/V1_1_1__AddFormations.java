package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_1_1__AddFormations extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO formations " +
                        "(formation_id, titre, num_eleve) values " +
                        "(1, 'MATH', 12)");
        statement.execute(
                "INSERT INTO formations " +
                        "(formation_id, titre, num_eleve) values " +
                        "(2, 'ANGLAIS', 21)");


    }
}