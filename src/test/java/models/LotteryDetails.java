package models;

public class LotteryDetails {


    private int lottoId;
    private Integer[] winningNumbers;
    private Winners winners;

    public LotteryDetails(int lottoId, Integer[] winningNumbers, Winners winners) {
        this.lottoId = lottoId;
        this.winningNumbers = winningNumbers;
        this.winners = winners;
    }

    public int getLottoId() {
        return lottoId;
    }

    public void setLottoId(int lottoId) {
        this.lottoId = lottoId;
    }

    public Integer[] getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(Integer[] winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static class Winners{

        private int winnerId;
        private Integer[] numbers;

        public Winners(int winnerId, Integer[] numbers) {
            this.winnerId = winnerId;
            this.numbers = numbers;
        }

        public int getWinnerId() {
            return winnerId;
        }

        public void setWinnerId(int winnerId) {
            this.winnerId = winnerId;
        }

        public Integer[] getNumbers() {
            return numbers;
        }

        public void setNumbers(Integer[] numbers) {
            this.numbers = numbers;
        }

    }
}
