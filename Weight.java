package org.example.model;
///*倒排索引中Map<String,List<wWeight>>中，关键词对应的信息，关键词*/
public class Weight {
    private DocInfo doc;
    private int weight;//权重值：通过标题和正文来计算关键词的数量
    private String keyword;//关键词

    @Override
    public String toString() {
        return "Weight{" +
                "doc=" + doc +
                ", weight=" + weight +
                ", keyword='" + keyword + '\'' +
                '}';
    }

    public DocInfo getDoc() {
        return doc;
    }

    public void setDoc(DocInfo doc) {
        this.doc = doc;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
