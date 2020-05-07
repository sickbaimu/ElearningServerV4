package liuxuan.education.entity;

public class WorkCommit {
    String userName;
    String commit;

    public WorkCommit(String userName, String commit) {
        this.userName = userName;
        this.commit = commit;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }
}
