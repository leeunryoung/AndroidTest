package J0512;

public class Page159 {

	public static void main(String[] args) {
	 int[] scores= {95,71,84,93,87};
	 int sum=0;
	 for (int score: scores) {
		 sum=sum+score;
//원래 for문
//	 for(i=0; i<scores.length-1; i++) {
//		 sum += scores[i];  위에 scores가 5개인데
//		i는 0부터 4까지 5개이므로 1개 초가됨 에러나오므로 ㅣ
		 //length에-1 했음.
	 }
	 System.out.println("점수 총합="+sum);
	 
	 double avg=(double)sum/scores.length;
	 System.out.println("점수 평균="+avg);
	 }

	}
//원래 꺼 약간내용수정후 출력해봄.
int sum3=0;
for (int i=0; i<scores.length; i+=2) {
	System.out.println(scores[i]+" ");
}
for (int i=2; i<scores.length; i++) {
	System.out.println(scores[i]+" ");
////

