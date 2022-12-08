package db.migration;

import be.ifosup.learning.utils.BCryptManagerUtil;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_2__AddStudents extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        String student1PasswordValue = BCryptManagerUtil.passwordEncoder().encode("STUDENT1");
        String student2PasswordValue = BCryptManagerUtil.passwordEncoder().encode("STUDENT2");
        String student3PasswordValue = BCryptManagerUtil.passwordEncoder().encode("STUDENT3");

        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO users " +
                        "(id_user, account_non_expired, account_non_locked, credentials_non_expired, enabled, firstname, lastname, password, username, email) values " +
                        "(4, 1, 1, 1, 1, 'Patrice', 'Rivard', 'student', 'patriceS', 'patricerivard@learning.com')");
        statement.execute(
                "INSERT INTO users " +
                        "(id_user, account_non_expired, account_non_locked, credentials_non_expired, enabled, firstname, lastname, password, username, email) values " +
                        "(5, 1, 1, 1, 1, 'Raymond', 'Pariseau', 'student', 'raymondS', 'raymondpariseau@learning.com')");
        statement.execute(
                "INSERT INTO users " +
                        "(id_user, account_non_expired, account_non_locked, credentials_non_expired, enabled, firstname, lastname, password, username, email) values " +
                        "(6, 1, 1, 1, 1, 'Sophie', 'Thibodeau', 'student', 'sophieS', 'sophiethibodeau@learning.com')");

        statement.execute("UPDATE users SET password='" + student1PasswordValue + "' WHERE username='patriceS'");
        statement.execute("INSERT INTO roles (id_user, `role`) values (4, 'STUDENT')");
        statement.execute("UPDATE users SET password='" + student2PasswordValue + "' WHERE username='raymondS'");
        statement.execute("INSERT INTO roles (id_user, `role`) values (5, 'STUDENT')");
        statement.execute("UPDATE users SET password='" + student3PasswordValue + "' WHERE username='sophieS'");
        statement.execute("INSERT INTO roles (id_user, `role`) values (6, 'STUDENT')");
    }
}
