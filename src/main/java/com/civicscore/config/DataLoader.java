//package com.civicscore.config;
//
//import com.civicscore.entity.Incentive;
//import com.civicscore.repository.IncentiveRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DataLoader implements CommandLineRunner {
//
//    private final IncentiveRepository incentiveRepository;
//
//    public DataLoader(IncentiveRepository incentiveRepository) {
//        this.incentiveRepository = incentiveRepository;
//    }
//
//    @Override
//    public void run(String... args) {
//
//        // Seed only if table is empty
//        if (incentiveRepository.count() == 0) {
//
//            incentiveRepository.save(
//                    new Incentive(null,
//                            "Public Transport Discount",
//                            800,
//                            "Discount on bus and metro fares")
//            );
//
//            incentiveRepository.save(
//                    new Incentive(null,
//                            "Priority Government Services",
//                            820,
//                            "Faster processing of government services")
//            );
//
//            incentiveRepository.save(
//                    new Incentive(null,
//                            "Clean City Recognition",
//                            850,
//                            "Recognition for civic responsibility")
//            );
//        }
//    }
//}
