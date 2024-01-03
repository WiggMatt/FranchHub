package ru.accelerator.FranchHub.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "location_map")
@Data
public class LocationMapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer map_id;
    @Column(columnDefinition = "INTEGER")
    private Integer franchiseId;
    @Column(columnDefinition = "INTEGER")
    private Integer moscow;
    @Column(columnDefinition = "INTEGER")
    private Integer stPetersburg;
    @Column(columnDefinition = "INTEGER")
    private Integer adygea;
    @Column(columnDefinition = "INTEGER")
    private Integer altai;
    @Column(columnDefinition = "INTEGER")
    private Integer altaiRepublic;
    @Column(columnDefinition = "INTEGER")
    private Integer zabaykalsky;
    @Column(columnDefinition = "INTEGER")
    private Integer amur;
    @Column(columnDefinition = "INTEGER")
    private Integer arkhangelsk;
    @Column(columnDefinition = "INTEGER")
    private Integer astrakhan;
    @Column(columnDefinition = "INTEGER")
    private Integer bashkortostan;
    @Column(columnDefinition = "INTEGER")
    private Integer belgorod;
    @Column(columnDefinition = "INTEGER")
    private Integer bryansk;
    @Column(columnDefinition = "INTEGER")
    private Integer buryatia;
    @Column(columnDefinition = "INTEGER")
    private Integer chechnya;
    @Column(columnDefinition = "INTEGER")
    private Integer chelyabinsk;
    @Column(columnDefinition = "INTEGER")
    private Integer chukotka;
    @Column(columnDefinition = "INTEGER")
    private Integer chuvashia;
    @Column(columnDefinition = "INTEGER")
    private Integer crimea;
    @Column(columnDefinition = "INTEGER")
    private Integer dagestan;
    @Column(columnDefinition = "INTEGER")
    private Integer donetsk;
    @Column(columnDefinition = "INTEGER")
    private Integer ingushetia;
    @Column(columnDefinition = "INTEGER")
    private Integer irkutsk;
    @Column(columnDefinition = "INTEGER")
    private Integer ivanovo;
    @Column(columnDefinition = "INTEGER")
    private Integer jewishAutonomousOblast;
    @Column(columnDefinition = "INTEGER")
    private Integer kabardinoBalkaria;
    @Column(columnDefinition = "INTEGER")
    private Integer kaliningrad;
    @Column(columnDefinition = "INTEGER")
    private Integer kalmykia;
    @Column(columnDefinition = "INTEGER")
    private Integer kaluga;
    @Column(columnDefinition = "INTEGER")
    private Integer kamchatka;
    @Column(columnDefinition = "INTEGER")
    private Integer karachayCherkessia;
    @Column(columnDefinition = "INTEGER")
    private Integer karelia;
    @Column(columnDefinition = "INTEGER")
    private Integer kemerovo;
    @Column(columnDefinition = "INTEGER")
    private Integer khabarovsk;
    @Column(columnDefinition = "INTEGER")
    private Integer khakassia;
    @Column(columnDefinition = "INTEGER")
    private Integer khantyMansi;
    @Column(columnDefinition = "INTEGER")
    private Integer kherson;
    @Column(columnDefinition = "INTEGER")
    private Integer kirov;
    @Column(columnDefinition = "INTEGER")
    private Integer komi;
    @Column(columnDefinition = "INTEGER")
    private Integer kostroma;
    @Column(columnDefinition = "INTEGER")
    private Integer krasnodar;
    @Column(columnDefinition = "INTEGER")
    private Integer krasnoyarsk;
    @Column(columnDefinition = "INTEGER")
    private Integer kurgan;
    @Column(columnDefinition = "INTEGER")
    private Integer kursk;
    @Column(columnDefinition = "INTEGER")
    private Integer leningrad;
    @Column(columnDefinition = "INTEGER")
    private Integer lipetsk;
    @Column(columnDefinition = "INTEGER")
    private Integer lugansk;
    @Column(columnDefinition = "INTEGER")
    private Integer magadan;
    @Column(columnDefinition = "INTEGER")
    private Integer mariEl;
    @Column(columnDefinition = "INTEGER")
    private Integer mordovia;
    @Column(columnDefinition = "INTEGER")
    private Integer moscowOblast;
    @Column(columnDefinition = "INTEGER")
    private Integer murmansk;
    @Column(columnDefinition = "INTEGER")
    private Integer nenets;
    @Column(columnDefinition = "INTEGER")
    private Integer nizhnyNovgorod;
    @Column(columnDefinition = "INTEGER")
    private Integer northOssetiaAlania;
    @Column(columnDefinition = "INTEGER")
    private Integer novgorod;
    @Column(columnDefinition = "INTEGER")
    private Integer novosibirsk;
    @Column(columnDefinition = "INTEGER")
    private Integer omsk;
    @Column(columnDefinition = "INTEGER")
    private Integer orel;
    @Column(columnDefinition = "INTEGER")
    private Integer orenburg;
    @Column(columnDefinition = "INTEGER")
    private Integer penza;
    @Column(columnDefinition = "INTEGER")
    private Integer perm;
    @Column(columnDefinition = "INTEGER")
    private Integer primorsky;
    @Column(columnDefinition = "INTEGER")
    private Integer pskov;
    @Column(columnDefinition = "INTEGER")
    private Integer rostov;
    @Column(columnDefinition = "INTEGER")
    private Integer ryazan;
    @Column(columnDefinition = "INTEGER")
    private Integer sakhaYakutia;
    @Column(columnDefinition = "INTEGER")
    private Integer sakhalin;
    @Column(columnDefinition = "INTEGER")
    private Integer samara;
    @Column(columnDefinition = "INTEGER")
    private Integer saratov;
    @Column(columnDefinition = "INTEGER")
    private Integer sevastopolCity;
    @Column(columnDefinition = "INTEGER")
    private Integer smolensk;
    @Column(columnDefinition = "INTEGER")
    private Integer stavropol;
    @Column(columnDefinition = "INTEGER")
    private Integer sverdlovsk;
    @Column(columnDefinition = "INTEGER")
    private Integer tambov;
    @Column(columnDefinition = "INTEGER")
    private Integer tatarstan;
    @Column(columnDefinition = "INTEGER")
    private Integer tomsk;
    @Column(columnDefinition = "INTEGER")
    private Integer tula;
    @Column(columnDefinition = "INTEGER")
    private Integer tuva;
    @Column(columnDefinition = "INTEGER")
    private Integer tver;
    @Column(columnDefinition = "INTEGER")
    private Integer tyumen;
    @Column(columnDefinition = "INTEGER")
    private Integer ulyanovsk;
    @Column(columnDefinition = "INTEGER")
    private Integer vladimir;
    @Column(columnDefinition = "INTEGER")
    private Integer volgograd;
    @Column(columnDefinition = "INTEGER")
    private Integer vologda;
    @Column(columnDefinition = "INTEGER")
    private Integer voronezh;
    @Column(columnDefinition = "INTEGER")
    private Integer yamaloNenets;
    @Column(columnDefinition = "INTEGER")
    private Integer yaroslavl;
    @Column(columnDefinition = "INTEGER")
    private Integer udmurtia;
    @Column(columnDefinition = "INTEGER")
    private Integer zaporozhye;
}
