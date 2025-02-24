/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.http.server.netty.jackson

import com.fasterxml.jackson.annotation.JsonView
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Controller("/jsonview")
class JsonViewController {

    static TestModel TEST_MODEL = new TestModel(firstName: "Bob", lastName: "Jones", birthdate: "08/01/1980", password: "secret")

    @Get("/none")
    HttpResponse<TestModel> none() {
        return HttpResponse.ok(TEST_MODEL)
    }

    @JsonView(Views.Public)
    @Get("/public")
    HttpResponse<TestModel> publicView() {
        return HttpResponse.ok(TEST_MODEL)
    }

    @JsonView(Views.Internal)
    @Get("/internal")
    HttpResponse<TestModel> internalView() {
        return HttpResponse.ok(TEST_MODEL)
    }

    @JsonView(Views.Admin)
    @Get("/admin")
    HttpResponse<TestModel> adminView() {
        return HttpResponse.ok(TEST_MODEL)
    }

    @JsonView(Views.Public)
    @Get("/reactive")
    Flux<TestModel> publicReactiveView() {
        return Flux.just(TEST_MODEL)
    }

    @JsonView(Views.Public)
    @Get("/reactive/single")
    Mono<TestModel> publicSingleView() {
        return Mono.just(TEST_MODEL)
    }

    @JsonView(Views.Public)
    @Get("/reactive/multiple")
    Flux<TestModel> publicReactiveViewMultiple() {
        return Flux.just(TEST_MODEL, TEST_MODEL)
    }
}
