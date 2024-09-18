package be.hanagami.whatsappclone.infrastructure.secondary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jdk.jfr.Name;
import org.jilt.Builder;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "authority")
@Builder
public class AuthorityEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(max = 50)
    @Id
    @Column(length = 50)
    private String name;

    public AuthorityEntity(String name) {
        this.name = name;
    }

    public AuthorityEntity() {
    }

    public static Set<AuthorityEntity> from(Set<Autority> autorities){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorityEntity that = (AuthorityEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
