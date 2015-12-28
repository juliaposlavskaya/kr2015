/**
 * Created by Julia on 28.12.2015.
 */
public class ResultsTable {

    public String nickname;
    public int account;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public ResultsTable(String nickname, int account){
        this.account = account;
        this.nickname = nickname;
    }

  /*  public ResultsTable(String str){
        String sss = str;
        String resultsT[] = sss.split("%");
        this.numbers = Integer.parseInt(resultsT[0]);
        this.nickname = resultsT[1];
        this.account = Integer.parseInt(resultsT[2]);
    }*/
}
