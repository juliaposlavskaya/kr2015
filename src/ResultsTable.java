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

    public ResultsTable(){

    }

    //разбивает одну заметку которую считали из файла
    public void createRec(String str){
        String sss = str;
        String resultsT[] = sss.split("%");
        this.nickname = resultsT[0];
        this.account = Integer.parseInt(resultsT[1]);
    }

    //преобразвание одного рещультата в стринг
    public String toString(){
        String str = this.nickname + "%" + this.account;
        return str;
    }
}
