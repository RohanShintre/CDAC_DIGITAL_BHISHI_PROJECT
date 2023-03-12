package rest.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "logId")
public class SessionLogs {
    @Id
    @GeneratedValue
    private int logId;
    private LocalDateTime sessionStart;
    private LocalDateTime sessionEnd;
    private int loginId;
    private int tokenId;

    public SessionLogs(LocalDateTime sessionStart, LocalDateTime sessionEnd, int loginId, int tokenId) {
        this.sessionStart = sessionStart;
        this.sessionEnd = sessionEnd;
        this.loginId = loginId;
        this.tokenId = tokenId;
    }

    public SessionLogs() {
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public LocalDateTime getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(LocalDateTime sessionStart) {
        this.sessionStart = sessionStart;
    }

    public LocalDateTime getSessionEnd() {
        return sessionEnd;
    }

    public void setSessionEnd(LocalDateTime sessionEnd) {
        this.sessionEnd = sessionEnd;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionLogs that = (SessionLogs) o;
        return logId == that.logId && loginId == that.loginId && tokenId == that.tokenId && Objects.equals(sessionStart, that.sessionStart) && Objects.equals(sessionEnd, that.sessionEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logId, sessionStart, sessionEnd, loginId, tokenId);
    }
}
