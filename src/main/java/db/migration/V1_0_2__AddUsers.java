package db.migration;

import be.ifosup.learning.utils.BCryptManagerUtil;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_2__AddUsers extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        String studentPasswordValue = BCryptManagerUtil.passwordEncoder().encode("STUDENT");
        String teacherPasswordValue = BCryptManagerUtil.passwordEncoder().encode("TEACHER");

        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO users " +
                        "(id_user, account_non_expired, account_non_locked, credentials_non_expired, enabled, firstname, lastname, password, username) values " +
                        "(3, 1, 1, 1, 1, 'Student FirstName', 'Student Lastname', 'student', 'student')");

        statement.execute("UPDATE users SET password='" + studentPasswordValue + "' WHERE username='student'");
        statement.execute("INSERT INTO roles (id_user, `role`) values (3, 'STUDENT')");


        statement.execute("UPDATE users SET username='teacher' WHERE username='user'");
        statement.execute("UPDATE users SET firstname='Teacher Firstname' WHERE username='teacher'");
        statement.execute("UPDATE users SET lastname='Teacher Lastname' WHERE username='teacher'");
        statement.execute("UPDATE users SET password='" + teacherPasswordValue + "' WHERE username='teacher'");
        statement.execute("UPDATE roles SET `role`='TEACHER' WHERE id_user='2'");
    }
}
