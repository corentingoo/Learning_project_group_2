package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_3_2__AddInscription extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO inscriptions " +
                        "(inscription_id, student_id, formation_id) values " +
                        "(1, 2, 1)");
        statement.execute(
                "INSERT INTO formations " +
                        "(formation_id, titre, num_eleve) values " +
                        "(2, 3, )");


    }
}