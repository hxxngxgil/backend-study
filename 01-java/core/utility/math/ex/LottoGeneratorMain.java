package lang.math.ex;

public class LottoGeneratorMain {

    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int[] lottoNumbers = lottoGenerator.generate();

        //로또 추첨
        System.out.print("로또 번호: ");
        for (int lottoNumber : lottoNumbers) {
            System.out.print(lottoNumber + " ");
        }
    }
}
