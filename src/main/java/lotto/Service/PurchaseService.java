package lotto.Service;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class PurchaseService {
    public PurchaseService() { }

    public int buy(int money) {
        boolean validated = false;
        if(validate(money))
            return money / 1000;
        return -1;
    }

    private boolean validate(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("[ERROR] 구매 가격은 음수가 될 수 없습니다.");
        }
        if(money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매는 1,000원 단위로 가능합니다.");
        }
        return true;
    }

    public List<Lotto> draw(int count) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        for(int i = 0; i < count; i++) {
            for(int j = 0; j < 6; j++) {
                List<Integer> numbers = new ArrayList<>();
                numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                Collections.sort(numbers);
                Lotto lotto = new Lotto(numbers);
                lottos.add(lotto);
            }
        }
        return lottos;
    }
}