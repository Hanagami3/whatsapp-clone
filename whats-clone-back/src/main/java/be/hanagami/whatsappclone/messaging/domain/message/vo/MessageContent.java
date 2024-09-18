package be.hanagami.whatsappclone.messaging.domain.message.vo;

public record MessageContent(String text,
                             MessageType type,
                             MessageMediaContent media
                             ) {
}
