package packChat.model;

public class BoardVO {
    private int boNum;
    private String boWriter;
    private String boTitle;
    private String boContent;
    private int cnt;

    public BoardVO(int boNum, String boWriter, String boTitle, String boContent) {
        this.boNum = boNum;
        this.boWriter = boWriter;
        this.boTitle = boTitle;
        this.boContent = boContent;
        this.cnt = 0;
    }

    public int getBoNum() {
        return boNum;
    }

    public void setBoNum(int boNum) {
        this.boNum = boNum;
    }

    public String getBoWriter() {
        return boWriter;
    }

    public void setBoWriter(String boWriter) {
        this.boWriter = boWriter;
    }

    public String getBoTitle() {
        return boTitle;
    }

    public void setBoTitle(String boTitle) {
        this.boTitle = boTitle;
    }

    public String getBoContent() {
        return boContent;
    }

    public void setBoContent(String boContent) {
        this.boContent = boContent;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void increaseViewCount() {
        this.cnt++;
    }
}