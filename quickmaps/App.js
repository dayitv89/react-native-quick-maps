/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import { Platform, StyleSheet, Text, View } from 'react-native';

import BaseCustomView from './components/BaseCustomView';

export default class App extends Component {
	render() {
		return (
			<View style={styles.container}>
				<BaseCustomView style={styles.instructions} />
			</View>
		);
	}
}

const styles = StyleSheet.create({
	container: {
		flex: 1,
		justifyContent: 'center',
		alignItems: 'center',
		backgroundColor: '#00ffff',
		padding: 20
	},
	welcome: {
		fontSize: 20,
		textAlign: 'center',
		margin: 10
	},
	instructions: {
		backgroundColor: 'green',
		marginBottom: 5,
		height: 200,
		width: 200
	}
});
