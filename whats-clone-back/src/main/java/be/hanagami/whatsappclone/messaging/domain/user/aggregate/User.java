package be.hanagami.whatsappclone.messaging.domain.user.aggregate;

import be.hanagami.whatsappclone.messaging.domain.user.vo.*;
import be.hanagami.whatsappclone.shared.error.domain.Assert;
import org.jilt.Builder;

import java.time.Instant;
import java.util.Set;

@Builder
public class User {

    private UserLastName lastName;

    private UserFirstName firstName;

    private UserEmail email;

    private UserPublicId userPublicId;

    private UserImageUrl imageUrl;

    private Instant lastModifiedDate;

    private Instant createDate;

    private Instant lastSeen;

    private Set<Authority> authorities;

    private Long dbId;

    public User(UserLastName lastName, UserFirstName firstName, UserEmail email, UserPublicId userPublicId,
                UserImageUrl ImageUrl, Instant lastModifiedDate, Instant crateDate, Instant lastSeen, Set<Authority> authorities, Long dbId) {
        assertMandatoryFields(lastName, firstName, email, authorities);
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.userPublicId = userPublicId;
        this.imageUrl = ImageUrl;
        this.lastModifiedDate = lastModifiedDate;
        this.createDate = crateDate;
        this.lastSeen = lastSeen;
        this.authorities = authorities;
        this.dbId = dbId;
    }

    private void assertMandatoryFields(UserLastName lastName,
                                       UserFirstName firstName,
                                       UserEmail email,
                                       Set<Authority> authorities){
        Assert.notNull("lastName", lastName);
        Assert.notNull("firstName", firstName);
        Assert.notNull("email", email);
        Assert.notNull("authorities", authorities);
    }

    public void updateFromUser(User user) {
        this.email = user.email;
        this.lastName = user.lastName;
        this.firstName = user.firstName;
        this.imageUrl = user.imageUrl;
    }

    public void initFieldForSignup(){
        this.lastSeen = Instant.now();
    }

    public UserLastName getLastName() {
        return lastName;
    }

    public UserFirstName getFirstName() {
        return firstName;
    }

    public UserEmail getEmail() {
        return email;
    }

    public UserPublicId getUserPublicId() {
        return userPublicId;
    }

    public UserImageUrl getImageUrl() {
        return imageUrl;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Instant getLastSeen() {
        return lastSeen;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public Long getDbId() {
        return dbId;
    }
}
