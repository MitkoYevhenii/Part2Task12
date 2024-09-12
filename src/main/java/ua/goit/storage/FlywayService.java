package ua.goit.storage;

import org.flywaydb.core.Flyway;

public class FlywayService {
    public static void initDataBase () {
        Flyway flyway =  Flyway
                .configure().dataSource(
                        StorageConstants.CONNECTION_URL,
                        StorageConstants.CONNECTION_USERNAME,
                        StorageConstants.CONNECTION_PASSWORD)
                .load();
        flyway.migrate();
    }

    public static void initDataBase (String url, String username, String password) {
        Flyway flyway =  Flyway
                .configure().dataSource(url, username, password)
                .load();
        flyway.migrate();
    }


    public static void cleanDatabase() {
        Flyway flyway = Flyway
                .configure()
                .dataSource(
                        StorageConstants.CONNECTION_URL,
                        StorageConstants.CONNECTION_USERNAME,
                        StorageConstants.CONNECTION_PASSWORD)
                .cleanDisabled(false) // Включаем возможность использовать clean
                .load();
        flyway.clean();
    }

    public static void cleanDatabase(String url, String username, String password) {
        Flyway flyway = Flyway
                .configure()
                .dataSource(url, username, password)
                .cleanDisabled(false) // Включаем возможность использовать clean
                .load();
        flyway.clean();
    }

    public static void main(String[] args) {
        initDataBase();
    }
}
