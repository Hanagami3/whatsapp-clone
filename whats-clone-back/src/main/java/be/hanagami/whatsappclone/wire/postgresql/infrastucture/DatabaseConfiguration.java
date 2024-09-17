package be.hanagami.whatsappclone.wire.postgresql.infrastucture;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"be.hanagami.whatsappclone"})
@EnableJpaAuditing
public class DatabaseConfiguration {
}
