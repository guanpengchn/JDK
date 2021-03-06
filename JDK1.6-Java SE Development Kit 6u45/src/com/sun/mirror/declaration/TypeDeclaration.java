/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.declaration;


import java.util.Collection;

import com.sun.mirror.type.*;


/**
 * Represents the declaration of a class or interface.
 * Provides access to information about the type and its members.
 * Note that an {@linkplain EnumDeclaration enum} is a kind of class,
 * and an {@linkplain AnnotationTypeDeclaration annotation type} is
 * a kind of interface.
 *
 * <p> <a name="DECL_VS_TYPE"></a>
 * While a <tt>TypeDeclaration</tt> represents the <i>declaration</i>
 * of a class or interface, a {@link DeclaredType} represents a class
 * or interface <i>type</i>, the latter being a use
 * (or <i>invocation</i>) of the former.
 * The distinction is most apparent with generic types,
 * for which a single declaration can define a whole
 * family of types.  For example, the declaration of
 * {@code java.util.Set} corresponds to the parameterized types
 * {@code java.util.Set<String>} and {@code java.util.Set<Number>}
 * (and many others), and to the raw type {@code java.util.Set}.
 *
 * <p> {@link com.sun.mirror.util.DeclarationFilter}
 * provides a simple way to select just the items of interest
 * when a method returns a collection of declarations.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 *
 * @see DeclaredType
 * @since 1.5
 */

public interface TypeDeclaration extends MemberDeclaration {

    /**
     * Returns the package within which this type is declared.
     *
     * @return the package within which this type is declared
     */
    PackageDeclaration getPackage();

    /**
     * Returns the fully qualified name of this class or interface
     * declaration.  More precisely, it returns the <i>canonical</i>
     * name.
     * The name of a generic type does not include any reference
     * to its formal type parameters.
     * For example, the the fully qualified name of the interface declaration
     * {@code java.util.Set<E>} is <tt>"java.util.Set"</tt>.
     *
     * @return the fully qualified name of this class or interface declaration
     */
    String getQualifiedName();

    /**
     * Returns the formal type parameters of this class or interface.
     *
     * @return the formal type parameters, or an empty collection
     * if there are none
     */
    Collection<TypeParameterDeclaration> getFormalTypeParameters();

    /**
     * Returns the interface types directly implemented by this class
     * or extended by this interface.
     *
     * @return the interface types directly implemented by this class
     * or extended by this interface, or an empty collection if there are none
     *
     * @see com.sun.mirror.util.DeclarationFilter
     */
    Collection<InterfaceType> getSuperinterfaces();

    /**
     * Returns the fields that are directly declared by this class or
     * interface.  Includes enum constants.
     *
     * @return the fields that are directly declared,
     * or an empty collection if there are none
     *
     * @see com.sun.mirror.util.DeclarationFilter
     */
    Collection<FieldDeclaration> getFields();

    /**
     * Returns the methods that are directly declared by this class or
     * interface.  Includes annotation type elements.  Excludes
     * implicitly declared methods of an interface, such as
     * <tt>toString</tt>, that correspond to the methods of
     * <tt>java.lang.Object</tt>.
     *
     * @return the methods that are directly declared,
     * or an empty collection if there are none
     *
     * @see com.sun.mirror.util.DeclarationFilter
     */
    Collection<? extends MethodDeclaration> getMethods();

    /**
     * Returns the declarations of the nested classes and interfaces
     * that are directly declared by this class or interface.
     *
     * @return the declarations of the nested classes and interfaces,
     * or an empty collection if there are none
     *
     * @see com.sun.mirror.util.DeclarationFilter
     */
    Collection<TypeDeclaration> getNestedTypes();
}
