package forum.model;

import java.time.LocalDateTime;

public class Post {
    private String subject, body;
    private LocalDateTime created_at;
    private User author;

    public Post(String subject, String body, LocalDateTime ldtWrited, User author) {
        this.subject = subject;
        this.body = body;
        this.created_at = ldtWrited;
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getLdtWrited() {
        return created_at;
    }

    public void setLdtWrited(LocalDateTime ldtWrited) {
        this.created_at = ldtWrited;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
