/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.context.scope;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.type.Argument;
import io.micronaut.inject.BeanType;

import java.lang.annotation.Annotation;
import java.util.Optional;

/**
 * An interface for a registry of {@link CustomScope} instances.
 *
 * @author Graeme Rocher
 * @since 1.0
 */
public interface CustomScopeRegistry {

    /**
     * Finds the declared scope for the given argument.
     *
     * @param argument The argument
     * @return An optional scope
     * @since 3.0.0
     */
    default Optional<CustomScope<?>> findDeclaredScope(@NonNull Argument<?> argument) {
        return Optional.empty();
    }

    /**
     * Finds the declared scope for the given bean type.
     *
     * @param beanType The bean type
     * @return An optional scope
     * @since 3.0.0
     */
    default Optional<CustomScope<?>> findDeclaredScope(@NonNull BeanType<?> beanType) {
        return Optional.empty();
    }

    /**
     * Find a custom scope for the given annotation.
     *
     * @param scopeAnnotation The scope annotation
     * @return The custom scope
     */
    Optional<CustomScope<?>> findScope(String scopeAnnotation);

    /**
     * Find a custom scope for the given annotation.
     *
     * @param scopeAnnotation The scope annotation
     * @return The custom scope
     */
    default Optional<CustomScope<?>> findScope(Class<? extends Annotation> scopeAnnotation) {
        return findScope(scopeAnnotation.getName());
    }
}
