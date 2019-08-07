package com.company.CapstoneProject1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

    @Entity
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Table(name="Company")
    public class Company {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer floor;
        @NotNull
        private Integer companyId;
        @NotNull
        @Length(max=20)
        private String companyName;
        @NotNull
        private Integer entries;
        @NotNull
        private Integer exits;


        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public Integer getFloor() {
            return floor;
        }

        public void setFloor(Integer floor) {
            this.floor = floor;
        }

        public Integer getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
        }

        public Integer getEntries() {
            return entries;
        }

        public void setEntries(Integer entries) {
            this.entries = entries;
        }

        public Integer getExits() {
            return exits;
        }

        public void setExits(Integer exits) {
            this.exits = exits;
        }




        public Company(String companyName) { } //Mockito test constructor for CompanyService.
        public void setCompanyName(Company company1) { //test constructor

        }
    }













