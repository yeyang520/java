package boy.learning.pojo;

public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPaasword() {
        return password;
    }

    public void setPassword(String paasword) {
        this.password = paasword;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", paasword='" + password + '\'' +
                '}';
    }
}
