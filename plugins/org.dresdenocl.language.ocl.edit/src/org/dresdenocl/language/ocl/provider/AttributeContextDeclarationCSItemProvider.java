/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.dresdenocl.language.ocl.provider;

import java.util.Collection;
import java.util.List;

import org.dresdenocl.language.ocl.AttributeContextDeclarationCS;
import org.dresdenocl.language.ocl.OclFactory;
import org.dresdenocl.language.ocl.OclPackage;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.dresdenocl.language.ocl.AttributeContextDeclarationCS} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class AttributeContextDeclarationCSItemProvider extends
		ContextDeclarationCSItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttributeContextDeclarationCSItemProvider(
			AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(OclPackage.Literals.ATTRIBUTE_CONTEXT_DECLARATION_CS__TYPE_NAME);
			childrenFeatures.add(OclPackage.Literals.ATTRIBUTE_CONTEXT_DECLARATION_CS__TYPE);
			childrenFeatures.add(OclPackage.Literals.ATTRIBUTE_CONTEXT_DECLARATION_CS__INIT_OR_DERIVE_VALUE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns AttributeContextDeclarationCS.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AttributeContextDeclarationCS"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return "context "
				+ ((AttributeContextDeclarationCS) object).getTypeName().getNamedElement()
						.getName();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AttributeContextDeclarationCS.class)) {
			case OclPackage.ATTRIBUTE_CONTEXT_DECLARATION_CS__TYPE_NAME:
			case OclPackage.ATTRIBUTE_CONTEXT_DECLARATION_CS__TYPE:
			case OclPackage.ATTRIBUTE_CONTEXT_DECLARATION_CS__INIT_OR_DERIVE_VALUE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.ATTRIBUTE_CONTEXT_DECLARATION_CS__TYPE_NAME,
				 OclFactory.eINSTANCE.createModelElementCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.ATTRIBUTE_CONTEXT_DECLARATION_CS__TYPE,
				 OclFactory.eINSTANCE.createTypeModelElementCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.ATTRIBUTE_CONTEXT_DECLARATION_CS__TYPE,
				 OclFactory.eINSTANCE.createTupleTypeCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.ATTRIBUTE_CONTEXT_DECLARATION_CS__TYPE,
				 OclFactory.eINSTANCE.createCollectionTypeIdentifierCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.ATTRIBUTE_CONTEXT_DECLARATION_CS__INIT_OR_DERIVE_VALUE,
				 OclFactory.eINSTANCE.createInitValueCS()));

		newChildDescriptors.add
			(createChildParameter
				(OclPackage.Literals.ATTRIBUTE_CONTEXT_DECLARATION_CS__INIT_OR_DERIVE_VALUE,
				 OclFactory.eINSTANCE.createDeriveValueCS()));
	}

}
