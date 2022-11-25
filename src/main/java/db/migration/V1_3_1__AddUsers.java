package db.migration;

import be.ifosup.learning.utils.BCryptManagerUtil;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_3_1__AddUsers extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        String studentPasswordValue = BCryptManagerUtil.passwordEncoder().encode("STUDENT2");
        String studentPasswordValue2 = BCryptManagerUtil.passwordEncoder().encode("STUDENT3");

        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO users " +
                        "(id_user, account_non_expired, account_non_locked, credentials_non_expired, enabled, firstname, lastname, password, username) values " +
                        "(4, 1, 1, 1, 1, 'Student FirstName2', 'Student Lastname2', 'student2', 'student2')");
        statement.execute(
                "INSERT INTO users " +
                        "(id_user, account_non_expired, account_non_locked, credentials_non_expired, enabled, firstname, lastname, password, username) values " +
                        "(5, 1, 1, 1, 1, 'Student FirstName3', 'Student Lastname3', 'student3', 'student3')");
        statement.execute("UPDATE users SET password='" + studentPasswordValue + "' WHERE username='student2'");
        statement.execute("INSERT INTO roles (id_user, `role`) values (4, 'STUDENT')");

        statement.execute("UPDATE users SET password='" + studentPasswordValue2 + "' WHERE username='student3'");
        statement.execute("INSERT INTO roles (id_user, `role`) values (5, 'STUDENT')");



    }
}
