package com.ad.service;

import com.ad.exception.AdException;
import com.ad.vo.AdUnitDistrictRequest;
import com.ad.vo.AdUnitDistrictResponse;
import com.ad.vo.AdUnitItRequest;
import com.ad.vo.AdUnitItResponse;
import com.ad.vo.AdUnitKeywordRequest;
import com.ad.vo.AdUnitKeywordResponse;
import com.ad.vo.AdUnitRequest;
import com.ad.vo.AdUnitResponse;
import com.ad.vo.CreativeUnitRequest;
import com.ad.vo.CreativeUnitResponse;

/**
 * Created by Qinyi.
 */
public interface IAdUnitService {

    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;

    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request)
        throws AdException;

    AdUnitItResponse createUnitIt(AdUnitItRequest request)
        throws AdException;

    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request)
        throws AdException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request)
        throws AdException;
}
