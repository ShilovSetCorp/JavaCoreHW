package com.roman.shilov.hw22.travelagency.countries.repo.impl.jdbc;

import com.roman.shilov.hw22.travelagency.common.solutions.utils.Months;
import com.roman.shilov.hw22.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw22.travelagency.countries.domain.ColdCountry;
import com.roman.shilov.hw22.travelagency.countries.domain.HotCountry;

import java.sql.ResultSet;

public final class CountryMapper {

    private static final String COUNTRY_CLASS_NAME = BaseCountry.class.getSimpleName();

    private CountryMapper() {
    }

    public static HotCountry mapHotCountry(ResultSet rs) throws Exception {
        try {
            HotCountry hotCountry = new HotCountry();
            hotCountry.setAverageTemp(rs.getInt("AVERAGE_TEMPERATURE"));
            hotCountry.setHottestMonth(Months.valueOf(rs.getString("HOTTEST_MONTH")));

            return hotCountry;
        } catch (Exception e) {
            throw new Exception("Hot country gone bad");
        }
    }

    public static ColdCountry mapColdCountry(ResultSet rs) throws Exception {
        try {
            ColdCountry coldCountry = new ColdCountry();
            coldCountry.setAverageSnowLevel(rs.getInt("AVERAGE_SNOW_LEVEL"));
            coldCountry.setTheMostSnowingMonth(Months.valueOf(rs.getString("SNOWING_MONTH")));
            coldCountry.setPolarNight(rs.getBoolean("POLAR_NIGHT"));

            return coldCountry;
        } catch (Exception e) {
            throw new Exception("Cold country gone bad");
        }
    }

    public static void mapCommonCountryData(BaseCountry country, ResultSet rs) throws Exception {
        try {
            country.setId(rs.getLong("ID"));
            country.setName(rs.getString("NAME"));
            country.setLanguage(rs.getString("LANGUAGE"));
            country.setTelephoneCode(rs.getString("TELEPHONE_CODE"));
        }catch (Exception e){
            throw new Exception("country bad at all");
        }
    }

}
