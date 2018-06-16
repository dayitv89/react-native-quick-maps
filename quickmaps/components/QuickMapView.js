import React, { Component } from 'react';
import { View, requireNativeComponent } from 'react-native';

import PropTypes from 'prop-types';

export default class QuickMapView extends Component {
	render() {
		return <R2RQuickMapView {...this.props} />;
	}
}

QuickMapView.propTypes = {
	myLocationEnable: PropTypes.bool,
	...View.propTypes
};

const R2RQuickMapView = requireNativeComponent('R2RQuickMapView', QuickMapView);
