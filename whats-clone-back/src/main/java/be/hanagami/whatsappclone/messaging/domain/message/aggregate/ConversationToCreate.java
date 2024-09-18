package be.hanagami.whatsappclone.messaging.domain.message.aggregate;

import be.hanagami.whatsappclone.messaging.domain.message.vo.ConversationName;
import be.hanagami.whatsappclone.messaging.domain.user.vo.UserPublicId;
import be.hanagami.whatsappclone.shared.error.domain.Assert;
import org.jilt.Builder;

import java.util.Set;

@Builder
public class ConversationToCreate {

    private final Set<UserPublicId> members;

    private final ConversationName name;

    public ConversationToCreate(Set<UserPublicId> members, ConversationName name) {
        assertMandatoryFields(members, name);
        this.members = members;
        this.name = name;
    }

    private void assertMandatoryFields(Set<UserPublicId> members, ConversationName name){
        Assert.notNull("name", name);
        Assert.notNull("members", members);
    }

    public Set<UserPublicId> getMembers() {
        return members;
    }

    public ConversationName getName() {
        return name;
    }
}
