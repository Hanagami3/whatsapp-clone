package be.hanagami.whatsappclone.infrastructure.secondary.entity;

import be.hanagami.whatsappclone.infrastructure.secondary.entity.UserEntityBuilder;
import be.hanagami.whatsappclone.messaging.domain.user.aggregate.User;
import be.hanagami.whatsappclone.messaging.domain.user.aggregate.UserBuilder;
import be.hanagami.whatsappclone.messaging.domain.user.vo.*;
import be.hanagami.whatsappclone.shared.jpa.AbstractAuditingEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
import org.jilt.Builder;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "whatsapp user")
@Builder
public class UserEntity extends AbstractAuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequenceGenerator")
    @SequenceGenerator(name = "userSequenceGenerator", sequenceName = "user_sequence", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "email")
    private String email;

    @Column(name = "image_url")
    private String imageUrl;

    @UuidGenerator
    @Column(name = "public_id", updatable = false)
    private UUID publicId;

    @Column(name = "last_seen")
    private Instant lastSeen = Instant.now();

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")}
    )
    private Set<AuthorityEntity> authorities = new HashSet<>();

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name = "user_conversation",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "conversation_id", referencedColumnName = "id")}
    )
    private Set<ConversationEntity> conversations = new HashSet<>();

    public UserEntity(Long id, String lastname, String firstname, String email, String imageUrl, UUID publicId,
                      Instant lastSeen, Set<AuthorityEntity> authorities, Set<ConversationEntity> conversations) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.imageUrl = imageUrl;
        this.publicId = publicId;
        this.lastSeen = lastSeen;
        this.authorities = authorities;
        this.conversations = conversations;
    }

    public UserEntity() {
    }

    public void updateFromUser(User user){
        this.email = user.getEmail().value();
        this.lastname = user.getLastName().value();
        this.firstname = user.getFirstName().value();
        this.imageUrl = user.getImageUrl().value();
    }

    public static UserEntity from(User user){
        UserEntityBuilder userEntityBuilder = UserEntityBuilder.userEntity();

        if (user.getImageUrl() != null) {
            userEntityBuilder.imageUrl(user.getImageUrl().value());
        }

        if (user.getUserPublicId() != null){
            userEntityBuilder.publicId(user.getUserPublicId().value());
        }

        return userEntityBuilder
                .authorities(AuthorityEntity.from(user.getAuthorities()))
                .email(user.getEmail().value())
                .firstname(user.getFirstName().value())
                .lastname(user.getLastName().value())
                .id(user.getDbId())
                .lastSeen(user.getLastSeen())
                .build();
    }

    public static User toDomain(UserEntity userEntity){
        UserBuilder userBuilder = UserBuilder.user();

        if (userEntity.getImageUrl() != null) {
            userBuilder.imageUrl(new UserImageUrl(userEntity.getImageUrl()));
        }

        return userBuilder
                .email(new UserEmail(userEntity.getEmail()))
                .lastName(new UserLastName(userEntity.getLastname()))
                .firstName(new UserFirstName(userEntity.getFirstname()))
                .authorities(AuthorityEntity.toDomain(userEntity.getAuthorities()))
                .userPublicId(new UserPublicId(userEntity.getPublicId()))
                .lastModifiedDate(userEntity.getLastModifiedDate())
                .createDate(userEntity.getCreatedDate())
                .dbId(userEntity.getId())
                .lastSeen(userEntity.getLastSeen())
                .build();
    }

    public static Set<UserEntity> from(List<User> users){
        return users.stream().map(UserEntity::from).collect(Collectors.toSet());
    }

    public static Set<User> toDomain(Set<UserEntity> user){
        return user.stream().map(UserEntity::toDomain).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public void setPublicId(UUID publicId) {
        this.publicId = publicId;
    }

    public Instant getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Instant lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Set<AuthorityEntity> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<AuthorityEntity> authorities) {
        this.authorities = authorities;
    }

    public Set<ConversationEntity> getConversations() {
        return conversations;
    }

    public void setConversations(Set<ConversationEntity> conversations) {
        this.conversations = conversations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(lastname, that.lastname) && Objects.equals(firstname, that.firstname) && Objects.equals(email, that.email) && Objects.equals(imageUrl, that.imageUrl) && Objects.equals(publicId, that.publicId) && Objects.equals(lastSeen, that.lastSeen);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(lastname);
        result = 31 * result + Objects.hashCode(firstname);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(imageUrl);
        result = 31 * result + Objects.hashCode(publicId);
        result = 31 * result + Objects.hashCode(lastSeen);
        return result;
    }
}
