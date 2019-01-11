package com.dongqilin.consumer;

import com.dongqilin.provider.HelloInterface;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @description:
 * @author: dongql
 * @date: 2019/1/8 17:22
 */
@FeignClient(name = "service-provider", fallback = HelloFallback.class)
public interface HelloFeginClient extends HelloInterface {
}
