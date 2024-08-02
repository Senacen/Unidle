package com.senacen.Unidle.run;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();
    public List<Run> findAll() {
        return runs;
    }
    public Optional<Run> findById(Integer id) {
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            runs.remove(existingRun.get());
        }
    }
    @PostConstruct
    private void init() {
        runs.add(new Run(1,
                "Monday Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                3,
                Location.INDOORS));
        runs.add(new Run(2,
                "Wednesday Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(60, ChronoUnit.MINUTES),
                6,
                Location.OUTDOORS));
    }
}
