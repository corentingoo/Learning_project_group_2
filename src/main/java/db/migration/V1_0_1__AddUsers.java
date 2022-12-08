package db.migration;

import be.ifosup.learning.utils.BCryptManagerUtil;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_1__AddUsers extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        String adminPasswordValue = BCryptManagerUtil.passwordEncoder().encode("ADMIN");
        String studentPasswordValue = BCryptManagerUtil.passwordEncoder().encode("STUDENT");
        String teacherPasswordValue = BCryptManagerUtil.passwordEncoder().encode("TEACHER");

        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO users " +
                        "(id_user, account_non_expired, account_non_locked, credentials_non_expired, enabled, firstname, lastname, password, username, email) values " +
                        "(1, 1, 1, 1, 1, 'Admin FirstName', 'Admin Lastname', 'admin', 'admin', 'admin@learning.com')");
        statement.execute(
                "INSERT INTO users " +
                        "(id_user, account_non_expired, account_non_locked, credentials_non_expired, enabled, firstname, lastname, password, username, email) values " +
                        "(2, 1, 1, 1, 1, 'TEACHER FirstName', 'Teacher Lastname', 'teacher', 'teacher', 'teacher@learning.com')");
        statement.execute(
                "INSERT INTO users " +
                        "(id_user, account_non_expired, account_non_locked, credentials_non_expired, enabled, firstname, lastname, password, username, email) values " +
                        "(3, 1, 1, 1, 1, 'Student FirstName', 'Student Lastname', 'student', 'student', 'student@learning.com')");

        statement.execute("UPDATE users SET password='" + adminPasswordValue + "' WHERE username='admin'");
        statement.execute("INSERT INTO roles (id_user, `role`) values (1, 'ADMIN')");
        statement.execute("UPDATE users SET password='" + teacherPasswordValue + "' WHERE username='teacher'");
        statement.execute("INSERT INTO roles (id_user, `role`) values (2, 'TEACHER')");
        statement.execute("UPDATE users SET password='" + studentPasswordValue + "' WHERE username='student'");
        statement.execute("INSERT INTO roles (id_user, `role`) values (3, 'STUDENT')");
    }
}
