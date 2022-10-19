package db.migration;

import be.ifosup.learning.utils.BCryptManagerUtil;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0_1__AddUsers extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        String adminPasswordValue = BCryptManagerUtil.passwordEncoder().encode("ADMIN");
        String userPasswordValue = BCryptManagerUtil.passwordEncoder().encode("USER");

        Statement statement = context.getConnection().createStatement();
        statement.execute(
                "INSERT INTO users " +
                        "(id_user, account_non_expired, account_non_locked, credentials_non_expired, enabled, firstname, lastname, password, username) values " +
                        "(1, 1, 1, 1, 1, 'Admin FirstName', 'Admin Lastname', 'admin', 'admin')");
        statement.execute(
                "INSERT INTO users " +
                        "(id_user, account_non_expired, account_non_locked, credentials_non_expired, enabled, firstname, lastname, password, username) values " +
                        "(2, 1, 1, 1, 1, 'User FirstName', 'User Lastname', 'user', 'user')");
        statement.execute("UPDATE users SET password='" + adminPasswordValue + "' WHERE username='admin'");
        statement.execute("INSERT INTO roles (id_user, `role`) values (1, 'ADMIN')");
        statement.execute("UPDATE users SET password='" + userPasswordValue + "' WHERE username='user'");
        statement.execute("INSERT INTO roles (id_user, `role`) values (2, 'USER')");
    }
}
