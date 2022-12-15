package db.migration;

import be.ifosup.learning.utils.BCryptManagerUtil;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_3__AddTeachers extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        String teacher1PasswordValue = BCryptManagerUtil.passwordEncoder().encode("TEACHER1");
        String teacher2PasswordValue = BCryptManagerUtil.passwordEncoder().encode("TEACHER2");
        String teacher3PasswordValue = BCryptManagerUtil.passwordEncoder().encode("TEACHER3");

        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO users " +
                        "(id_user, account_non_expired, account_non_locked, credentials_non_expired, enabled, firstname, lastname, password, username, email) values " +
                        "(7, 1, 1, 1, 1, 'Ancelina', 'Boutot', 'teacher', 'ancelinaP', 'ancelinaboutot@learning.com')");
        statement.execute(
                "INSERT INTO users " +
                        "(id_user, account_non_expired, account_non_locked, credentials_non_expired, enabled, firstname, lastname, password, username, email) values " +
                        "(8, 1, 1, 1, 1, 'Royden', 'Marquis', 'teacher', 'roydenP', 'roydenarquis@learning.com')");
        statement.execute(
                "INSERT INTO users " +
                        "(id_user, account_non_expired, account_non_locked, credentials_non_expired, enabled, firstname, lastname, password, username, email) values " +
                        "(9, 1, 1, 1, 1, 'Fifine', 'Boisclair', 'teacher', 'fifineP', 'learningifosup@proton.me')");

        statement.execute("UPDATE users SET password='" + teacher1PasswordValue + "' WHERE username='ancelinaP'");
        statement.execute("INSERT INTO roles (id_user, `role`) values (7, 'TEACHER')");
        statement.execute("UPDATE users SET password='" + teacher2PasswordValue + "' WHERE username='roydenP'");
        statement.execute("INSERT INTO roles (id_user, `role`) values (8, 'TEACHER')");
        statement.execute("UPDATE users SET password='" + teacher3PasswordValue + "' WHERE username='fifineP'");
        statement.execute("INSERT INTO roles (id_user, `role`) values (9, 'TEACHER')");
    }
}
