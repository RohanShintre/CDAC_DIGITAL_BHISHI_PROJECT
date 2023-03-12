package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entity.Bhishi;
import rest.repository.BhishiRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BhishiService {
    @Autowired
    private BhishiRepository bhishiRepository;

    public List<Bhishi> getAllBhishi(){
        List<Bhishi> allBhishi = bhishiRepository.findAll();
        return allBhishi;
    }

    public Bhishi getOneBhishi(Integer BhishiId) {
        Optional<Bhishi> bhishiOpt = bhishiRepository.findById(BhishiId);
        Bhishi foundBhishi = bhishiOpt.get();
        return foundBhishi;
    }

    public Bhishi createBhishi(Bhishi Bhishi) {
        Bhishi createdBhishi = bhishiRepository.save(Bhishi);
        return createdBhishi;
    }

    public void deleteOneBhishi(Integer BhishiId) {
        bhishiRepository.deleteById(BhishiId);
    }

    public void updatePadeUpValues(Integer bhishiId, double paidUpValues) {
        bhishiRepository.updatePaidUpValues(bhishiId, paidUpValues);
    }

}
