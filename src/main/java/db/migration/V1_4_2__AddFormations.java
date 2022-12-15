package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_4_2__AddFormations extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO formations " +
                        "(formation_id, titre, num_eleve, date_debut, date_fin, teacher, type) values " +
                        "(1, 'Java Spring', 1, '2022-09-08', '2022-12-15', 7, 1)");
        statement.execute(
                "INSERT INTO formations " +
                        "(formation_id, titre, num_eleve, date_debut, date_fin, teacher, type) values " +
                        "(2, 'ANGLAIS A1', 20, '2022-09-08', '2022-12-23', 9, 2)");
        statement.execute(
                "INSERT INTO formations " +
                        "(formation_id, titre, num_eleve, date_debut, date_fin, teacher, type) values " +
                        "(3, 'ANGLAIS A2', 20, '2022-09-08', '2022-12-23', 9, 2)");
        statement.execute(
                "INSERT INTO formations " +
                        "(formation_id, titre, num_eleve, date_debut, date_fin, teacher, type) values " +
                        "(4, 'ANGLAIS A3', 20, '2022-09-08', '2022-12-23', 9, 2)");


    }
}