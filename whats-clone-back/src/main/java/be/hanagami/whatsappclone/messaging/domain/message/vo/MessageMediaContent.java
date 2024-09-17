package be.hanagami.whatsappclone.messaging.domain.message.vo;

public record MessageMediaContent(byte[] file,
                                  String mimeType) {
}
