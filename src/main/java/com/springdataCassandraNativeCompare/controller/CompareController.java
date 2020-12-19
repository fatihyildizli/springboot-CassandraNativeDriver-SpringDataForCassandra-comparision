package com.springdataCassandraNativeCompare.controller;


import com.springdataCassandraNativeCompare.springData.SpringDataRepository;
import com.springdataCassandraNativeCompare.springData.entity.DummyItem;
import com.springdataCassandraNativeCompare.cassandraNative.CassandraNativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;


/**
 * @author Fatih Yıldızlı
 */

@RestController
public class CompareController {

    @Autowired
    SpringDataRepository springDataRepository;

    @Autowired
    CassandraNativeRepository cassandraNativeRepository;


    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/select/springdata", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> selectSpringData() {
        Long startTime = System.currentTimeMillis();
        List<DummyItem> response = springDataRepository.selectAll();
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/select/cassandraNative", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> selectCassandraNative() {
        Long startTime = System.currentTimeMillis();
        List<DummyItem> response = cassandraNativeRepository.selectAll();
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/insert/springdata/{count}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> insertSpringData(@PathVariable("count") int count) {
        Long startTime = System.currentTimeMillis();
        IntStream.range(0,count).forEach(i-> springDataRepository.insert(i, "yıldızlı", "fatih"));
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/insert/cassandraNative/{count}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> insertCassandraNative(@PathVariable("count") int count) {

        Long startTime = System.currentTimeMillis();
        IntStream.range(0,count).forEach(i-> cassandraNativeRepository.insertAll(i));
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }


    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/update/springdata/{count}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> updateSpringData(@PathVariable("count") int count) {

        Long startTime = System.currentTimeMillis();
        IntStream.range(0,count).forEach(i-> springDataRepository.update(i, "FYildizli", "fatih"));
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/update/cassandraNative/{count}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> updateCassandraNative(@PathVariable("count") int count) {

        Long startTime = System.currentTimeMillis();
        IntStream.range(0,count).forEach(i-> cassandraNativeRepository.updateAll(i));
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/delete/springdata/{count}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> deleteSpringData(@PathVariable("count") int count) {

        Long startTime = System.currentTimeMillis();
        IntStream.range(0,count).forEach(i-> springDataRepository.delete(i));
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/delete/cassandraNative/{count}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> deleteCassandraNative(@PathVariable("count") int count) {

        Long startTime = System.currentTimeMillis();
        IntStream.range(0,count).forEach(i-> cassandraNativeRepository.deleteAll(i));
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }

}
