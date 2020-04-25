package com.ad.service;

import com.ad.vo.CreativeRequest;
import com.ad.vo.CreativeResponse;

/**
 * Created by Qinyi.
 */
public interface ICreativeService {

    CreativeResponse createCreative(CreativeRequest request);
}
