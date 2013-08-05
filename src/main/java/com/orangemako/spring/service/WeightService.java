package com.orangemako.spring.service;

import com.orangemako.spring.domain.User;
import com.orangemako.spring.domain.Weight;
import com.orangemako.spring.repository.WeightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Weight Service.
 *
 * @author Kevin Leong
 */
@Service
public class WeightService {
    private static final Logger LOG = LoggerFactory.getLogger(WeightService.class);

    @Resource
    WeightRepository weightRepository;

    public int uploadWeightCsv(String filePath) {

        BufferedReader br;
        String delimiter = ",";
        String line;

        List<Weight> weightList = new LinkedList<Weight>();

        try {
            br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null) {

                Weight weight = new Weight();

                String[] weightData = line.split(delimiter);

                // Format Date
                String dateEnteredRaw = weightData[0];
                SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yy");
                //dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date date = dateFormat.parse(dateEnteredRaw);

                User user = new User();
                user.setId(Long.parseLong(weightData[1]));

                Double value = Double.parseDouble(weightData[2]);

                weight.setUser(user);
                weight.setValue(value);
                weight.setDateEntered(date);

                weightList.add(weight);
            }
            weightRepository.save(weightList);
        }
        catch (Exception e) {
            if (e.getClass() == IOException.class) {
                LOG.error("File not found: " + filePath);
            }
            else if (e.getClass() == ParseException.class) {
                LOG.error("Parsing exception");
            }

            return -1;
        }

        return weightList.size();
    }
}
